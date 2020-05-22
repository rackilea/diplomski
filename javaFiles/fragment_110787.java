if $app_v2 == 'true' {
        systemd::service {'app':
            user => 'java',
            exec => "${java_home}/bin/java \
            -server \
            '-XX:OnOutOfMemoryError=\\'kill -9 %%p\\'' \
            -Dmw.config=/etc/app/app_new.config \
            -cp /usr/share/app/app.jar ru.app.main.App app",
        }
    } else {
        systemd::service {'app':
            user => 'java',
            exec => "${java_home}/bin/java \
            -server \
            '-XX:OnOutOfMemoryError=\\'kill -9 %%p\\'' \
            -Dmw.config=/etc/app/app.config \
            -cp /usr/share/app/app.jar ru.app.main.Main app",
        }
    }