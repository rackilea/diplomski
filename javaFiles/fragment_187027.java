...
[INFO] --- maven-timestamp-plugin:1.0:create (default) @ jee-agents-distribution-tomcat-v6 ---
[INFO]
[INFO] --- maven-svn-revision-number-plugin:1.6:revision (default) @ jee-agents-distribution-tomcat-v6 ---
[INFO] inspecting C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-distribution\jee-agents-distribution-tomcat-v6
[INFO]
[INFO] --- properties-maven-plugin:1.0-alpha-2:read-project-properties (default) @ jee-agents-distribution-tomcat-v6 ---
[INFO]
[INFO] --- maven-assembly-plugin:2.4:single (tomcat-v6-assembly) @ jee-agents-distribution-tomcat-v6 ---
[INFO] Reading assembly descriptor: src/main/assembly/tomcat-v6_KitAssembly_Descriptor.xml
[WARNING] Cannot include project artifact: org.forgerock.openam.agents:jee-agents-distribution-tomcat-v6:pom:3.3.0; it doesn't have an associated file or directory.
[WARNING] Cannot include project artifact: org.forgerock.openam.agents:jee-agents-distribution-tomcat-v6:pom:3.3.0; it doesn't have an associated file or directory.
[WARNING] Cannot include project artifact: org.forgerock.openam.agents:jee-agents-distribution-tomcat-v6:pom:3.3.0; it doesn't have an associated file or directory.
[WARNING] Cannot include project artifact: org.forgerock.openam.agents:jee-agents-distribution-tomcat-v6:pom:3.3.0; it doesn't have an associated file or directory.
[WARNING] Cannot include project artifact: org.forgerock.openam.agents:jee-agents-distribution-tomcat-v6:pom:3.3.0; it doesn't have an associated file or directory.
[INFO] Building zip: C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-distribution\jee-agents-distribution-tomcat-v6\target\Tomcat-v6-7-Agent-3.3.0.zip
[INFO]
[INFO] --- maven-resources-plugin:2.6:copy-resources (copy-build_date.js) @ jee-agents-distribution-tomcat-v6 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-dependency-plugin:2.6:analyze-only (analyze) @ 
jee-agents-distribution-tomcat-v6 ---
[INFO] Skipping pom project
[INFO]
[INFO] --- checksum-maven-plugin:1.0.1:artifacts (generate-checksum) @ 
jee-agents-distribution-tomcat-v6 ---
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ 
jee-agents-distribution-tomcat-v6 ---
[INFO] Installing C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-distribution\
jee-agents-distribution-tomcat-v6\pom.xml to C:\Documents and 
Settings\Clasmir\.m2\repository\org\forgerock\openam\agents\jee-agents-distribution-tomcat-v6\
3.3.0\jee-agents-distribution-tomcat-v6-3.3.0.pom
[INFO] Installing C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-distribution\
jee-agents-distribution-tomcat-v6\target\Tomcat-v6-7-Agent-3.3.0.zip to C:\Documents and 
Settings\Clasmir\.m2\repository\org\forgerock\openam\agents\jee-agents-distribution-tomcat-v6\
3.3.0\jee-agents-distribution-tomcat-v6-3.3.0.zip
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] OpenAM JavaEE Policy Agents ....................... SUCCESS [16.644s]
[INFO] OpenAM JavaEE Policy Agents AgentSDK .............. SUCCESS [13.740s]
[INFO] OpenAM JavaEE Policy Agents AgentApp .............. SUCCESS [2.774s]
[INFO] OpenAM JavaEE Policy Agents Tomcat ................ SUCCESS [0.080s]
[INFO] OpenAM JavaEE Policy Agents Tomcat v6 ............. SUCCESS [5.318s]
[INFO] OpenAM JavaEE Policy Agents SampleApp ............. SUCCESS [0.170s]
[INFO] OpenAM JavaEE Policy Agents SampleApp Web Servlets  SUCCESS [0.581s]
[INFO] OpenAM JavaEE Policy Agents SampleApp Tomcat ...... SUCCESS [0.681s]
[INFO] OpenAM JavaEE Policy Agents Distribution .......... SUCCESS [3.035s]
[INFO] OpenAM JavaEE Policy Agents Distribution Tomcat v6  SUCCESS [3.445s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 47.109s
[INFO] Finished at: Thu Mar 27 14:20:45 EDT 2014
[INFO] Final Memory: 24M/58M
[INFO] ------------------------------------------------------------------------
$


Thanks for the help.

-Dennis



On Thu, Mar 27, 2014 at 1:01 PM,  wrote:

> What version of Maven are you using? I am using v3.0.5 and these 
> missing dependencies came up as warnings so the build succeeded. 
> Alternatively you could just create some dummy files to match the 
> missing dependencies or alter the top-level pom to not build those 
> modules.
> 
> 
> Thanks
> 
> Mark
> 
> 
> On 28/03/2014, at 5:40,  wrote:
> 
>> Is it possible that steps like this are still required?
>> 
>> Granted these were for ant based builds:
>> 
>> 
>> https://svn.forgerock.org/openam/tags/j2eeagents_303_stable/opensso/products/j2eeagents/README 
>> 
>> 
>> 2.3.2 Obtaining libraries for WebLogic 10.0
>> Follow these steps to obtain the libraries for BEA WebLogic 10.0:
>> 2.3.2.1 Install BEA WebLogic 10.0 server
>> 2.3.2.2 Copy weblogic.jar and api.jar both from the lib directory of 
>> the server
>> installation(for example from /bea/wlserver_10.0/server/lib) into
>> the opensso/products/j2eeagents/extlib/weblogic/v10 directory of this 
>> workspace
>> 2.3.2.3 Copy the com.bea.core.weblogic.security_2.0.0.0.jar from the
>> modules directory of the server installation(for example from 
>> /bea/modules)
>> into the opensso/products/j2eeagents/extlib/weblogic/v10 directory of 
>> this workspace.
>> 
>> 
>> 
>> 
>> On Thu, Mar 27, 2014 at 12:13 PM,  wrote:
>> 
>>> Thank you Peter for responding. You are a huge help.
>>> 
>>> To be safe, I created a new directory :
>>> 
>>> /cygdrive/c/Dev/openam/JEEAgents-3.3.0
>>> 
>>> And I used a 1.6 version of SVN to download all of this:
>>> 
>>> https://svn.forgerock.org/openam/tags/JEEAgents-3.3.0 
>>> 
>>> I then went to this directory:
>>> 
>>> /cygdrive/c/Dev/openam/JEEAgents-3.3.0/openam-agents/jee-agents
>>> 
>>> I issued this command:
>>> 
>>> $ mvn -am -pl 
>>> jee-agents-distribution/jee-agents-distribution-tomcat-v6 clean 
>>> install
>>> 
>>> and I get this error:
>>> 
>>> [INFO] Scanning for projects...
>>> [ERROR] The build could not read 3 projects -> [Help 1]
>>> [ERROR]
>>> [ERROR]   The project 
>>> org.forgerock.openam.agents:jee-agents-weblogic-v10:3.3.0 
>>> (C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-weblogic\jee-agents-weblogic-v10\pom.xml) 
>>> has 4 errors
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> weblogic:com.bea.core.common.security.api:jar must specify an 
>>> absolute path but is 
>>> /var/tmp/extlib/weblogic/v10/com.bea.core.common.security.api_1.0.0.0_5-1-0-0.jar 
>>> @ line 103, column 25
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> weblogic:com.bea.core.weblogic.security.auth:jar must specify an 
>>> absolute path but is 
>>> /var/tmp/extlib/weblogic/v10/com.bea.core.weblogic.security.auth_1.0.0.0.jar 
>>> @ line 110, column 25
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> weblogic:com.bea.core.weblogic.security:jar must specify an absolute 
>>> path but is 
>>> /var/tmp/extlib/weblogic/v10/com.bea.core.weblogic.security_1.0.0.0_5-1-0-0.jar 
>>> @ line 117, column 25
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> weblogic:weblogic:jar must specify an absolute path but is 
>>> /var/tmp/extlib/weblogic/v10/weblogic.jar @ line 124, column 25
>>> [ERROR]
>>> [ERROR]   The project 
>>> org.forgerock.openam.agents:jee-agents-websphere-common:3.3.0 
>>> (C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-websphere\jee-agents-websphere-common\pom.xml) 
>>> has 1 error
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> websphere:com.ibm.ws.runtime:jar must specify an absolute path but 
>>> is /var/tmp/extlib/websphere/v61/com.ibm.ws.runtime_6.1.0.jar @ line 
>>> 84, column 25
>>> [ERROR]
>>> [ERROR]   The project 
>>> org.forgerock.openam.agents:jee-agents-websphere-v61:3.3.0 
>>> (C:\Dev\openam\JEEAgents-3.3.0\openam-agents\jee-agents\jee-agents-websphere\jee-agents-websphere-v61\pom.xml) 
>>> has 1 error
>>> [ERROR]     'dependencies.dependency.systemPath' for 
>>> websphere:com.ibm.ws.runtime:jar must specify an absolute path but 
>>> is /var/tmp/extlib/websphere/v61/com.ibm.ws.runtime_6.1.0.jar @ line 
>>> 109, column 25
>>> [ERROR]
>>> [ERROR] To see the full stack trace of the errors, re-run Maven with 
>>> the -e switch.
>>> [ERROR] Re-run Maven using the -X switch to enable full debug 
>>> logging.
>>> [ERROR]
>>> [ERROR] For more information about the errors and possible 
>>> solutions, please read the following articles:
>>> [ERROR] [Help 1] 
>>> http://cwiki.apache.org/confluence/display/MAVEN/ProjectBuildingException 
>>> 
>>> 
>>> 
>>> On Thu, Mar 27, 2014 at 6:14 AM, Major Péter wrote:
>>> 
>>>> Hi,
>>>> 
>>>> I hope you've checked out the correct tag for building 3.3.0 JEE 
>>>> agents:
>>>> https://svn.forgerock.org/openam/tags/JEEAgents-3.3.0/ 
>>>> 
>>>> To build the tomcat agent run the following command from the 
>>>> jee-agents dir:
>>>> mvn -am -pl 
>>>> jee-agents-distribution/jee-agents-distribution-tomcat-v6 clean 
>>>> install
>>>> 
>>>> cheers,
>>>> Peter
>>>> 
>>>> 2014.03.26. 14:12 :
>>>>> Hello,
>>>>> 
>>>>> I hope this the right place to ask.
>>>>> 
>>>>> I've built 11.0 successfully but I am having difficulty building 
>>>>> the
>>>>> tomcat agent.
>>>>> 
>>>>> 
>>>>> 
>>>>> /11.0/openam-agents/jee-agents/jee-agents-tomcat/jee-agents-tomcat-v6
>>>>> 
>>>>> I have built successfully:
>>>>> 
>>>>>     jee-agents-sdk
>>>>> 
>>>>> When I issue the command "mvn -U -DskipTests=true clean install" 
>>>>> within
>>>>> the tomcat6 directory, I get this error which I'm assuming is 
>>>>> because I
>>>>> have not placed the tomcat 6 jar files somewhere for maven to find 
>>>>> them.
>>>>> 
>>>>> Here is the error:
>>>>> 
>>>>> Downloading:
>>>>> 
>>>>> 
>>>>> http://maven.forgerock.org/repo/maven-central/org/forgerock/openam/openam-installtools-launcher/11.0.0-SNAPSHOT/maven-metadata.xml 
>>>>> Downloaded:
>>>>> 
>>>>> 
>>>>> http://maven.forgerock.org/repo/snapshots/org/forgerock/openam/openam-installtools-launcher/11.0.0-SNAPSHOT/maven-metadata.xml 
>>>>> (793 B at 8.6 KB/sec)
>>>>> [INFO]
>>>>> 
>>>>> 
>>>>> ------------------------------------------------------------------------
>>>>> [INFO] BUILD FAILURE
>>>>> [INFO]
>>>>> 
>>>>> 
>>>>> ------------------------------------------------------------------------
>>>>> [INFO] Total time: 4.607s
>>>>> [INFO] Finished at: Tue Mar 25 17:15:16 EDT 2014
>>>>> [INFO] Final Memory: 7M/16M
>>>>> [INFO]
>>>>> 
>>>>> 
>>>>> ------------------------------------------------------------------------
>>>>> [ERROR] Failed to execute goal on project jee-agents-tomcat-v6: 
>>>>> Could
>>>>> not resolve dependencies for project
>>>>> 
>>>>> org.forgerock.openam.agents:jee-agents-tomcat-v6:jar:3.2.0-SNAPSHOT:
>>>>> Failed to collect dependencies for
>>>>> [org.forgerock.openam.agents:jee-agents-sdk:jar:3.2.0-SNAPSHOT
>>>>> (compile), org.apache.tomcat:catalina:jar:6.0.36 (provided),
>>>>> javax.servlet:servlet-api:jar:2.5 (provided),
>>>>> javax.servlet.jsp:jsp-api:jar:2.1 (provided), 
>>>>> javaee:javaee-api:jar:5
>>>>> (provided), commons-io:commons-io:jar:1.4 (provided),
>>>>> org.forgerock.openam:openam-clientsdk:jar:11.0.0-SNAPSHOT 
>>>>> (provided),
>>>>> org.forgerock.openam:openam-installtools:jar:11.0.0-SNAPSHOT 
>>>>> (provided),
>>>>> 
>>>>> org.forgerock.openam:openam-installtools-launcher:jar:11.0.0-SNAPSHOT
>>>>> (provided), com.sun:tools:jar:1.5 (system?)]: Failed to read 
>>>>> artifact
>>>>> descriptor for
>>>>> org.forgerock.openam.agents:jee-agents-sdk:jar:3.2.0-SNAPSHOT: 
>>>>> Could not
>>>>> find artifact 
>>>>> org.forgerock.openam.agents:jee-agents:pom:3.2.0-SNAPSHOT
>>>>> in forgerock-snapshots-repo 
>>>>> (http://maven.forgerock.org/repo/snapshots )
>>>>> -> [Help 1]
>>>>> [ERROR]
>>>>> [ERROR] To see the full stack trace of the errors, re-run Maven 
>>>>> with the
>>>>> -e switch.
>>>>> [ERROR] Re-run Maven using the -X switch to enable full debug 
>>>>> logging.
>>>>> [ERROR]
>>>>> [ERROR] For more information about the errors and possible 
>>>>> solutions,
>>>>> please read the following articles:
>>>>> [ERROR] [Help 1]
>>>>> 
>>>>> 
>>>>> http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException 
>>>>> $ pwd
>>>>> 
>>>>> 
>>>>> /cygdrive/c/Dev/openam/11.0/openam-agents/jee-agents/jee-agents-tomcat/jee-agents-tomcat-v6
>>>>> 
>>>>> I'm not sure what to do.
>>>>> 
>>>>> -Dennis
>>>>> 
>>>>>