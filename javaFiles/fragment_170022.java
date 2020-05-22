void createAcl(Class clazz, Long id, String sid, AclObjectIdentity parent) {
    clazz = ProxyUtils.unproxy(clazz)
    AclClass aclClass = AclClass.findOrSaveByClassName(clazz.name)
    AclSid ownerSid = AclSid.findOrSaveBySidAndPrincipal(sid, true)
    AclObjectIdentity oid = findOrCreateObjectIdentity(aclClass, ownerSid, id, parent, true)
}

AclObjectIdentity findOrCreateObjectIdentity(AclClass aclClass, AclSid ownerSid, Long id, AclObjectIdentity parent, boolean entriesInheriting) {
    assert aclClass, "aclClass is required"
    assert null != id, "id is required"

    AclObjectIdentity oid = AclObjectIdentity.findOrCreateByAclClassAndObjectId(aclClass, id)
    if (null == oid.id) {
        oid.entriesInheriting = entriesInheriting
        oid.owner = ownerSid
        oid.parent = parent
        oid.save(flush: true, failOnError: true)
    }
    oid
}