body
{
  "action" : "addAPI",
  "name" : "employee",
  "context" : "/employee",
  "version" : "1.0.0",
  "visibility" : "public",
  "thumburl" : "",
  "description" : "list employees",
  "tags" : "company,employees",
  "endpointType" : "nonsecured",
  "tiersCollection" : "Gold,Silver",

  "http_checked" : "http",
  "https_checked" : "https",

  "bizOwner" : "xx",
  "bizOwnerMail" : "xx@ee.com",
  "techOwner" : "xx",
  "techOwnerMail" : "xx@ee.com",

  'resourceCount': '0',
  'resourceMethod-0': 'GET',
  "resourceMethodAuthType-0" : "Application",
  'resourceMethodThrottlingTier-0': 'Unlimited',
  "uriTemplate-0" : "/*",

  'default_version_checked': 'default_version',

  'endpoint_config': '{"production_endpoints":{"url":"http://ws.cdyne.com/phoneverify/phoneverify.asmx","config":null},"endpoint_type":"http"}'
}