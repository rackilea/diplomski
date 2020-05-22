{
    "unit": "WAS-WDI",
    "version": "20.1.1.0",
    "defaultPropertiesTargetPath": "{{user.home}}/{{component}}/deployments/{{module}}/properties",
    "templateFiles": [
        {
            "templateFileName": "EnvWDI.ht",
            "templateName": "EnvWDI",
            "targetFileName": "EnvWDI{{env}}{{client}}"
        },
        {
            "templateFileName": "WDIHealthCheck.ht",
            "templateName": "WDIHealthCheck",
            "targetFileName": "WDIHealthCheck{{env}}{{client}}"
        },
        {
            "targetPath": "{{user.home}}/{{component}}/properties/cache",
            "templateFileName": "CachesWDI.ht",
            "templateName": "CachesWDI",
            "targetFileName": "CachesWDI{{env}}{{client}}"
        }
    ],
    "module": "wdiCore"
}