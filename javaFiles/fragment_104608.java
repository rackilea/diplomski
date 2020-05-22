{
    "rules": [{
        "rule-type": "selection",
        "rule-id": "1",
        "rule-name": "1",
        "object-locator": {
            "schema-name": "test",
            "table-name": "%"
        },
        "rule-action": "include"
    }, {
        "rule-type": "transformation",
        "rule-id": "2",
        "rule-name": "2",
        "rule-action": "remove-column",
        "rule-target": "column",
        "object-locator": {
            "schema-name": "test",
            "table-name": "Actor",
            "column-name": "col%"
        }
    }]
 }