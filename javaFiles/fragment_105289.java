UserResource userResource=kc.realm("master").users().get(id);
CredentialRepresentation newCredential = new CredentialRepresentation();
newCredential.setType(PASSWORD);
newCredential.setValue("Tersting1");
newCredential.setTemporary(false);
userResource.resetPassword(newCredential);`