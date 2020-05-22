[#ftl]
${.version}

[#macro printForm s]
s: ${s}
[/#macro] 

[#assign myForm = { "id": 0 } ]

[@printForm (myForm.id == 0)?string('add', 'change') /]