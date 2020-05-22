private static ExpectedCondition<Boolean> angularIsFinished() {
    return new ExpectedCondition<Boolean>() {
        public Boolean apply(final WebDriver driver) {
            Object result = null;

            boolean isAngular2Plus = false;

            while(result == null || result.toString().equals("undefined")) {
                result = ((JavascriptExecutor)driver).executeScript("return typeof angular;");
                if (result == null || result.toString().equals("undefined")) {
                    result = ((JavascriptExecutor)driver).executeScript("return typeof window.getAngularTestability;");
                    if (result != null && !result.toString().equals("undefined")) {
                        isAngular2Plus = true;
                    }
                }

                try {
                    Thread.sleep(200L);
                } catch (final InterruptedException ex) {
                    logger.error("Error while trying to sleep", ex);
                }
            }

            final String script;
            if (isAngular2Plus) {
                script ="  var testability = window.getAllAngularTestabilities()[0];\n" +
                        "  var callback = arguments[arguments.length - 1];\n" +
                        "  testability.whenStable(callback);";
            } else {
                script ="  var el = document.querySelector(\"body\");\n" +
                        "  var callback = arguments[arguments.length - 1];\n" +
                        "  angular.element(el).injector().get('$browser').notifyWhenNoOutstandingRequests(callback);";
            }
            ((JavascriptExecutor) driver).executeAsyncScript(script);
            return true;
        }

        public String toString() {
            return "Wait for AngularJS";
        }
    };
}