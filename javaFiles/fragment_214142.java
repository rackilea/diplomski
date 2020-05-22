PUT https://{server}/restapi/{apiVersion}/accounts/{accountId}/envelopes/
{envelopeId}
X-DocuSign-Authentication:
<DocuSignCredentials><Username>{name}</Username><Password>{password}</Password><Integrato
rKey>{integrator_key}</IntegratorKey></DocuSignCredentials>
Accept: application/json
Content-Type: application/json
{
"status":"voided",
"voidedReason":"voided for incorrect recipient"
}