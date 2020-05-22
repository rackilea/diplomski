Param(
   [string]$collectionurl = "http://server:8080/tfs/Collection",
   [string]$projectName = "ProjectName",
   [string]$keepForever = "true",
   [string]$user = "username",
   [string]$token = "token",
   [string]$releasedDefinitionId = "2" 
)

# Base64-encodes the Personal Access Token (PAT) appropriately
$base64AuthInfo = [Convert]::ToBase64String([Text.Encoding]::ASCII.GetBytes(("{0}:{1}" -f $user,$token)))

function CreateJsonBody
{

    $value = @"
{
 "definitionId":$releasedDefinitionId,
  "description":"",
   "artifacts":[
         {
           "alias":"VSTEST",
           "instanceReference":{
                     "name":"20171123.1",
                     "id":"1256",
                     "sourceBranch":"$/0418Scrum/web0418"}
        }],
    "isDraft":false,
    "manualEnvironments":[]
}

"@

 return $value
}

$json = CreateJsonBody

$uri = "$($collectionurl)/$($projectName)/_apis/Release/releases?api-version=2.3-preview.1"
$result = Invoke-RestMethod -Uri $uri -Method Post -Body $json -ContentType "application/json" -Headers @{Authorization=("Basic {0}" -f $base64AuthInfo)}

$ReleaseID = $result.id

Write-Host "ReleaseID:" $ReleaseID