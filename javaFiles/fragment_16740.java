distinct-values(//(*|@*)[namespace-uri()]
                    /concat(if(. intersect ../@*)
                              then '@'
                              else (),
                            local-name(),
                            ', ',
                            substring-before(name(), ':'),
                            ', ',
                            namespace-uri(),
                            '&#xA;'
                            )
                )