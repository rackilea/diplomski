processResources {
        filesMatching('application.yaml') {
            filter ReplaceTokens, tokens: [
                    'api.port'         : project.property('api.port')
            ]
        }
    }