<Routing name="MyRoutingAppender">
        <Routes pattern="$${logger:name}">
            <Route>
                <File
                    fileName="logs/${logger:name}.txt"
                    name="appender-${logger:name}">
                    <PatternLayout>
                        <Pattern>%d{HH:mm:ss.SSS} [%t] %-5level ${logger:name} - %msg%n</Pattern>
                    </PatternLayout>
                </File>
            </Route>
        </Routes>
    </Routing>