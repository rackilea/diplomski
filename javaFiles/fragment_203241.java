package com.web.authorization;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.ExecutionException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.WebSecurityManager;

public class FakeWebSecurityManager implements WebSecurityManager {

    @Override
    public Subject login(final Subject subject, final AuthenticationToken authenticationToken) throws AuthenticationException { return null; }

    @Override
    public void logout(final Subject subject) { }

    @Override
    public Subject createSubject(final SubjectContext context) {
        return new Subject(){

            @Override
            public Object getPrincipal() { return null; }

            @Override
            public PrincipalCollection getPrincipals() {  return null; }

            @Override
            public boolean isPermitted(final String permission) { return true; }

            @Override
            public boolean isPermitted(final Permission permission) { return true; }

            @Override
            public boolean[] isPermitted(final String... permissions) { return null; }

            @Override
            public boolean[] isPermitted(final List<Permission> permissions) { return null; }

            @Override
            public boolean isPermittedAll(final String... permissions) { return true; }

            @Override
            public boolean isPermittedAll(final Collection<Permission> permissions) { return true; }

            @Override
            public void checkPermission(final String permission) throws AuthorizationException { }

            @Override
            public void checkPermission(final Permission permission) throws AuthorizationException { }

            @Override
            public void checkPermissions(final String... permissions) throws AuthorizationException { }

            @Override
            public void checkPermissions(final Collection<Permission> permissions) throws AuthorizationException { }

            @Override
            public boolean hasRole(final String roleIdentifier) { return true; }

            @Override
            public boolean[] hasRoles(final List<String> roleIdentifiers) { return null; }

            @Override
            public boolean hasAllRoles(final Collection<String> roleIdentifiers) { return true; }

            @Override
            public void checkRole(final String roleIdentifier) throws AuthorizationException { }

            @Override
            public void checkRoles(final Collection<String> roleIdentifiers) throws AuthorizationException { }

            @Override
            public void checkRoles(final String... roleIdentifiers) throws AuthorizationException { }

            @Override
            public void login(final AuthenticationToken token) throws AuthenticationException { }

            @Override
            public boolean isAuthenticated() { return true; }

            @Override
            public boolean isRemembered() { return false; }

            @Override
            public Session getSession() { return null; }

            @Override
            public Session getSession(final boolean create) { return null; }

            @Override
            public void logout() { }

            @Override
            public <V> V execute(final Callable<V> callable) throws ExecutionException { return null; }

            @Override
            public void execute(final Runnable runnable) { }

            @Override
            public <V> Callable<V> associateWith(final Callable<V> callable) { return null; }

            @Override
            public Runnable associateWith(final Runnable runnable) { return null; }

            @Override
            public void runAs(final PrincipalCollection principals) throws NullPointerException, IllegalStateException { }

            @Override
            public boolean isRunAs() { return false; }

            @Override
            public PrincipalCollection getPreviousPrincipals() { return null; }

            @Override
            public PrincipalCollection releaseRunAs() { return null; }};
    }

    @Override
    public AuthenticationInfo authenticate(final AuthenticationToken authenticationToken) throws AuthenticationException {  return null; }

    @Override
    public boolean isPermitted(final PrincipalCollection principals, final String permission) { return true; }

    @Override
    public boolean isPermitted(final PrincipalCollection subjectPrincipal, final Permission permission) { return true; }

    @Override
    public boolean[] isPermitted(final PrincipalCollection subjectPrincipal, final String... permissions) { return null; }

    @Override
    public boolean[] isPermitted(final PrincipalCollection subjectPrincipal, final List<Permission> permissions) { return null; }

    @Override
    public boolean isPermittedAll(final PrincipalCollection subjectPrincipal, final String... permissions) { return true; }

    @Override
    public boolean isPermittedAll(final PrincipalCollection subjectPrincipal, final Collection<Permission> permissions) { return true; }

    @Override
    public void checkPermission(final PrincipalCollection subjectPrincipal, final String permission) throws AuthorizationException { }

    @Override
    public void checkPermission(final PrincipalCollection subjectPrincipal, final Permission permission) throws AuthorizationException { }

    @Override
    public void checkPermissions(final PrincipalCollection subjectPrincipal, final String... permissions) throws AuthorizationException { }

    @Override
    public void checkPermissions(final PrincipalCollection subjectPrincipal, final Collection<Permission> permissions) throws AuthorizationException { }

    @Override
    public boolean hasRole(final PrincipalCollection subjectPrincipal, final String roleIdentifier) { return true; }

    @Override
    public boolean[] hasRoles(final PrincipalCollection subjectPrincipal, final List<String> roleIdentifiers) { return null; }

    @Override
    public boolean hasAllRoles(final PrincipalCollection subjectPrincipal, final Collection<String> roleIdentifiers) { return true; }

    @Override
    public void checkRole(final PrincipalCollection subjectPrincipal, final String roleIdentifier) throws AuthorizationException { }

    @Override
    public void checkRoles(final PrincipalCollection subjectPrincipal, final Collection<String> roleIdentifiers) throws AuthorizationException { }

    @Override
    public void checkRoles(final PrincipalCollection subjectPrincipal, final String... roleIdentifiers) throws AuthorizationException { }

    @Override
    public Session start(final SessionContext context) { return null; }

    @Override
    public Session getSession(final SessionKey key) throws SessionException { return null; }

    @Override
    public boolean isHttpSessionMode() { return false; }
}