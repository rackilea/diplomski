What type of user do you wish to add? 
 a) Management User (mgmt-users.properties) 
 b) Application User (application-users.properties)
(a): b

Enter the details of the new user to add.
Using realm 'ApplicationRealm' as discovered from the existing property files.
Username : jmsuser
User 'jmsuser' already exists and is enabled, would you like to... 
 a) Update the existing user password and roles 
 b) Disable the existing user 
 c) Type a new username
(a): a
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password : 
Re-enter Password : 
What groups do you want this user to belong to? (Please enter a comma separated list, or leave blank for none)[guest]: guest
Updated user 'jmsuser' to file '/Users/jsensharma/NotBackedUp/Installed/wildfly-10.0.0.CR3-SNAPSHOT/standalone/configuration/application-users.properties'
Updated user 'jmsuser' to file '/Users/jsensharma/NotBackedUp/Installed/wildfly-10.0.0.CR3-SNAPSHOT/domain/configuration/application-users.properties'
Updated user 'jmsuser' with groups guest to file '/Users/jsensharma/NotBackedUp/Installed/wildfly-10.0.0.CR3-SNAPSHOT/standalone/configuration/application-roles.properties'
Updated user 'jmsuser' with groups guest to file '/Users/jsensharma/NotBackedUp/Installed/wildfly-10.0.0.CR3-SNAPSHOT/domain/configuration/application-roles.properties'
Is this new user going to be used for one AS process to connect to another AS process? 
e.g. for a slave host controller connecting to the master or for a Remoting connection for server to server EJB calls.
yes/no? yes
To represent the user add the following to the server-identities definition <secret value="am1zdXNlckAxMjM=" />