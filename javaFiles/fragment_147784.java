ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeAsyncScript(
            "var callback = arguments[arguments.length - 1];" +
                    "if (document.readyState !== 'complete') {" +
                    "  callback('document not ready');" +
                    "} else {" +
                    "  try {" +
                    "    var testabilities = window.getAllAngularTestabilities();" +
                    "    var count = testabilities.length;" +
                    "    var decrement = function() {" +
                    "      count--;" +
                    "      if (count === 0) {" +
                    "        callback('complete');" +
                    "      }" +
                    "    };" +
                    "    testabilities.forEach(function(testability) {" +
                    "      testability.whenStable(decrement);" +
                    "    });" +
                    "  } catch (err) {" +
                    "    callback(err.message);" +
                    "  }" +
                    "}"
    ).toString().equals("complete");
    try {
        WebDriverWait wait = new WebDriverWait(webDriver(), 15);
        wait.until(expectation);
    } catch (Throwable error) {
        new Exception("Timeout waiting for Page Load Request to complete.");
    }