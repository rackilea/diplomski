Param(
   [string]$baseurl = "http://server:8080/tfs/CollectionLC",
   [string]$projectName = "ProjectName",
   [string]$keepForever = "true",
   [string]$user = "username",
   [string]$token = "token",
   [string]$ReleaseID = "3" 
)

# Base64-encodes the Personal Access Token (PAT) appropriately
$base64AuthInfo = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(("{0}:{1}" -f $user,$token)))

#Get releaseresponse
$Releaseurl= "$baseurl/$projectName/_apis/Release/releases/$ReleaseID" 

$releaseresponse = Invoke-RestMethod -Method Get -UseDefaultCredentials -ContentType application/json -Uri $Releaseurl

#Get all of the environment IDs from the release response:
$environmentIDs = $releaseresponse.environments.ForEach("id")

#Get the specific environment ID by grabbing the element in the environment IDs array:
$firstEnvironment = $environmentIDs[0]
$secondEnvironment = $environmentIDs[1]
$thirdEnvironment = $environmentIDs[2] # ...

#Create the JSON body for the deployment:
$deploymentbody = @" 
{"status": "inprogress"} 
"@

#Invoke the REST method to redeploy the release:
$DeployUrl = "$baseurl/$projectName/_apis/release/releases/$releaseid/environments/"+$thirdEnvironment+"?api-version=2.3-preview.1" # Change the envrionment ID accordingly based on your requirement.

$DeployRelease = Invoke-RestMethod -Method Patch -ContentType application/json -Uri $DeployUrl -Headers @{Authorization=("Basic {0}" -f $base64authinfo)} -Body $deploymentbody

write-host "environmentIDs:" $environmentIDs