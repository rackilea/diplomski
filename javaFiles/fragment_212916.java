angular.module('appBoot')
  .factory('XSRFInterceptor', function ($cookies, $log) {

    var XSRFInterceptor = {

      request: function(config) {

        var token = $cookies.get('XSRF-TOKEN');

        if (token) {
          config.headers['X-XSRF-TOKEN'] = token;
          $log.info("X-XSRF-TOKEN: " + token);
        }

        return config;
      }
    };
    return XSRFInterceptor;
  });

angular.module('appBoot', ['ngCookies', 'ngMessages', 'ui.bootstrap', 'vcRecaptcha'])
    .config(['$httpProvider', function ($httpProvider) {

      $httpProvider.defaults.withCredentials = true;
      $httpProvider.interceptors.push('XSRFInterceptor');

    }]);