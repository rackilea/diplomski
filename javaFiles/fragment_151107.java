Background:
* def data = { one: 1, two: 2, three: 3 }

Scenario Outline:
* match data.<key> == <value>

Examples:
| key   | value |
| one   | 1     |
| two   | 2     |
| three | 3     |