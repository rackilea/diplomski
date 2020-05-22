require 'selenium-webdriver'

driver = Selenium::WebDriver.for :firefox
driver.get "file:///C:/userdata/arupruby/test.html"

# To search the drop-down element whose id is 's'
elem = driver.find_element(:id,'s')
sel = Selenium::WebDriver::Support::Select.new(elem)

# To search if any element is present which has the disabled attribute.
dis_elem = sel.options.find{|e| e.attribute('disabled') }
dis_elem.text unless dis_elem.nil? # => "1"