package com.roberto.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.*;
import org.springframework.stereotype.Service;

/**
 * Service class to handle ACL permissions.
 */
@Service
public class ACLService {
    private final MutableAclService mutableAclService;

    @Autowired
    public ACLService(MutableAclService mutableAclService) {
        this.mutableAclService = mutableAclService;
    }

    /**
     * Insert an ACL entry
     * @param oid represents the model object
     * @param recipient represents the principal (user, group of users, etc)
     * @param permission quite explicit name...
     * @return the new ACL database entry
     */
    public MutableAcl addPermission(ObjectIdentity oid, Sid recipient, Permission permission) {
        MutableAcl acl;

        try {
            acl = (MutableAcl) mutableAclService.readAclById(oid);
        } catch (NotFoundException nfe) {
            acl = mutableAclService.createAcl(oid);
        }

        acl.insertAce(acl.getEntries().size(), permission, recipient, true);
        return mutableAclService.updateAcl(acl);
    }   
}