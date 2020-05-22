Use generic Map
backup => {addresses=[127.0.0.1], healthcheck_interval=60, http=https, port=9001}
cognito => {addresses=[127.0.0.1], http=https, port=9012}
collector => {addresses=[127.0.0.1], healthcheck_interval=60, http=https, port=9000}
ds => {addresses=[127.0.0.1], http=https, port=9011}
insight-analytics => {addresses=[127.0.0.1], http=https, port=9013}
integrations => {addresses=[127.0.0.1], http=https, port=9014}
server => {addresses=[127.0.0.1], healthcheck_interval=60, http=https, port=9009}
vigile => {addresses=[127.0.0.1], http=https, port=9443}
walt => {addresses=[127.0.0.1], http=https, port=9010}


Use Service Map
backup => Service{addresses=[127.0.0.1], healthCheckInterval=60, http='https', port=9001}
cognito => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9012}
collector => Service{addresses=[127.0.0.1], healthCheckInterval=60, http='https', port=9000}
ds => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9011}
insight-analytics => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9013}
integrations => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9014}
server => Service{addresses=[127.0.0.1], healthCheckInterval=60, http='https', port=9009}
vigile => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9443}
walt => Service{addresses=[127.0.0.1], healthCheckInterval=0, http='https', port=9010}