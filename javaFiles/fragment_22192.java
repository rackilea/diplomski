$scope.logoDropzoneConfig = {
                parallelUploads: 1,
                maxFileSize: 30,
                url: '/api/companies/upload/logo',
                headers: {
                    'Authorization' :AuthServerProvider.getToken()
                }
            };