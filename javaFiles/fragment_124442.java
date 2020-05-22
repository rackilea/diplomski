package com.roberto.security.service;

import com.roberto.model.TimeSheet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.acls.domain.BasePermission;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.domain.PrincipalSid;
import org.springframework.security.acls.model.*;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

/**
 * This test handles basic interaction between our codebase
 * Spring Security ACL and the underlying database model
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ACLServiceIntegrationTest {

    private Authentication authentication;
    private ObjectIdentity oid ;
    private Sid sid;
    private Permission administration = BasePermission.ADMINISTRATION;

    @Autowired
    private ACLService aclService;

    @Autowired
    private MutableAclService mutableAclService;

    @Autowired
    private PermissionEvaluator permissionEvaluator;

    @Before
    public void setUp() {
        authentication = TestSecurityContextHolder.getContext().getAuthentication();
        sid = new PrincipalSid(((JwtUser) authentication.getPrincipal()).getUsername());
        oid = new ObjectIdentityImpl(TimeSheet.class, 1);
    }

    @Test
    @WithUserDetails("admin")
    public void testBeans() {
        assertNotNull(aclService);
        assertNotNull(mutableAclService);
        assertNotNull(permissionEvaluator);
    }

    @Test
    @Transactional
    @WithUserDetails("admin")
    @DirtiesContext(methodMode = AFTER_METHOD)
    public void addPermissionIntegrationTest() {
        assertFalse(permissionEvaluator.hasPermission(authentication, oid.getIdentifier(), oid.getType(), administration));

        MutableAcl acl = aclService.addPermission(oi, sid, administration);

        assertTrue(permissionEvaluator.hasPermission(authentication, oid.getIdentifier(), oid.getType(), administration));

        assertEquals(TimeSheet.class.toString().split(" ")[1], acl.getObjectIdentity().getType());
        assertTrue(acl.getEntries().stream().anyMatch(e -> e.getSid().equals(sid) && e.getPermission().equals(administration)));
        assertTrue(acl.isGranted(List.of(administration), List.of(sid), true));
    }
}