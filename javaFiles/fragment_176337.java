{ 
   "_id" : ObjectId("587cb19d1db2732183afb0ab"), 
   "_class" : "org.parkcity.model.security.User", 
   "username" : "admin", 
   "password" : "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", 
   "firstname" : "admin", 
   "lastname" : "admin", 
   "email" : "admin@admin.com", 
   "enabled" : true, 
   "lastPasswordResetDate" : ISODate("2017-01-16T11:42:21.537+0000"), 
   "authorities" : [
       DBRef("authority", ObjectId("587cb19d1db2732183afb0a9")), 
       DBRef("authority", ObjectId("587cb19d1db2732183afb0aa"))
   ]
 }
 { 
   "_id" : ObjectId("587cb1a11db2732183afb0ac"), 
   "_class" : "org.parkcity.model.security.User", 
   "username" : "user", 
   "password" :    "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC", 
   "firstname" : "user", 
   "lastname" : "user", 
   "email" : "user@user.com", 
   "enabled" : true, 
   "lastPasswordResetDate" : ISODate("2017-01-16T11:42:21.620+0000"), 
   "authorities" : [
       DBRef("authority", ObjectId("587cb19d1db2732183afb0aa"))
   ]
}