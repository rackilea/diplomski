package com.abhi
import java.util
import javax.naming.ldap._
import javax.naming._
import javax.naming.directory.SearchControls
import scala.collection.mutable.ArrayBuffer

object LDAPScala extends App {
   val base = "dc=FOO,dc=COM"
   val env = new util.Hashtable[String, String]()
   env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
   env.put(Context.SECURITY_AUTHENTICATION, "simple")
   env.put(Context.SECURITY_PRINCIPAL, "user@foo.com")
   env.put(Context.SECURITY_CREDENTIALS, "pass")
   env.put(Context.PROVIDER_URL, "ldap://adserver.foo.com:389")
   val groupList = List("group1", "group2", "group3")

   try {
      val people = for {
         group <- groupList
         cn <- queryAD(base, s"(&(objectCategory=group)(name=${group}))", "member")
         sam <- queryAD(cn, "(sAMAccountName=*)", "samaccountname")
         name <- getName(cn)
      } yield (group, sam, name)
      people.foreach{case (g, s, n) => println(s"$g,$s,$n")}
   } catch {
      case e : Exception =>
         println(e.getMessage)
         println(e.getStackTrace)
   }

   def getName(cn: String): Option[String] = {
      val regex = """^CN=([\w\s\d]*),.*$""".r
      cn match {
         case regex(name) => Some(name)
         case _ => None
      }
   }

   def queryAD(base: String, searchFilter: String, attribute: String): List[String] = {
      val ctx = new InitialLdapContext(env, null)
      val searchCtls = new SearchControls()
      searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE)
      searchCtls.setReturningAttributes(Array(attribute))
      val answers = ctx.search(base, searchFilter, searchCtls)
      var retVal = ArrayBuffer[String]()
      while(answers.hasMoreElements) {
         val answer = answers.next()
         val member = answer.getAttributes.get(attribute).getAll
         while(member.hasMoreElements) {
            val person = member.next().toString
            retVal += person
         }
      }
      retVal.toList
   }
}