#
# features/support/env.rb
#
$: << File.join(File.dirname(__FILE__), "..", "..", "lib")

browser = :chrome #:htmlunit #:chrome #:firefox

host = ENV['TESTHOST'] || 'http://localhost:8080'
# may be non url was given
if not host.include?("//")
  host = "https://#{host}"
end

ENV['LANG'] = "en_US.UTF-8"

require 'rubygems'
require 'capybara'
require 'capybara/cucumber'
require 'selenium-webdriver'

require 'culerity' if browser == :htmlunit

case browser
when :htmlunit
  Capybara.default_driver = :culerity
  Capybara.use_default_driver
else
  Capybara.default_driver = :selenium
  Capybara.app_host = host
end

Capybara.run_server = false
if Capybara.default_driver == :selenium
  Capybara::Driver::Selenium.browser = browser
  driver = Selenium::WebDriver.for browser
end