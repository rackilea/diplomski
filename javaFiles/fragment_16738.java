distinct-values(//*[namespace-uri()]
                    /concat(local-name(),
                            ', ',
                            substring-before(name(), ':'),
                            ', ',
                            namespace-uri(),
                            '&#xA;'
                            )
                )