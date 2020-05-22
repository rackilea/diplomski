final String java_script =
"var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
"ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
"ction(format,data){this.items[format]=data;this.types.append(for" +
"mat);},getData:function(format){return this.items[format];},clea" +
"rData:function(format){}};var emit=function(event,target){var ev" +
"t=document.createEvent('Event');evt.initEvent(event,true,false);" +
"evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
"dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
"'drop',tgt);emit('dragend',src);";


driver.get("http://html5demos.com/drag");
WebElement LocatorFrom =driver.findElement(By.id("three"));
WebElement LocatorTo = driver.findElement(By.id("bin"));
((JavascriptExecutor)driver).executeScript(java_script, LocatorFrom, LocatorTo);