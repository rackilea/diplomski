{
"name": "default",
"ordering": "1",
"rule": [
    "com.walterjwhite.email.organization.api.configuration.rule.GroupRule",
    {
        "criteriaType": "Should",
        "rules": ["java.util.HashSet",[[
            "com.walterjwhite.email.organization.api.configuration.rule.AttributeRule",
            {
                "emailMessageField": ["com.walterjwhite.email.organization.api.configuration.rule.EmailMessageField", "Subject"],
                "values": ["java.util.HashSet", [
                    "default"
                ]],
                "matchType": ["com.walterjwhite.email.organization.api.configuration.rule.MatchType","ContainsIgnoreCase"]
            }]]
        ]
    }
],
"actionClassNames": ["java.util.ArrayList",[
    "com.walterjwhite.email.organization.plugins.count.CountAction",
    "com.walterjwhite.email.organization.plugins.index.IndexAction",
    "com.walterjwhite.email.organization.plugins.reply.MoveAction"
    ]
]