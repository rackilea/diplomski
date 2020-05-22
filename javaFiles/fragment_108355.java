testCompile ("org.mockito:mockito-core:${versions.mockito}") {
    exclude group: 'org.hamcrest', module: 'hamcrest-core'
}

['powermock-api-mockito-common',
'powermock-api-mockito',
'powermock-core',
'powermock-module-junit4',
'powermock-module-junit4-common',
'powermock-api-support',
'powermock-api-easymock',
'powermock-module-javaagent',
'powermock-module-junit4-rule-agent'].each {
    testCompile ("org.powermock:${it}:${versions.powermock}") {
        exclude group: 'org.mockito', module: 'mockito-core'
    }  
}