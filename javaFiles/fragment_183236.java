// switch to search form frame
 driver.switchTo().frame(0);

 // enter search keywords and click go
 ...

 // switch back to topmost frame in the current window.
 // this is very important, you can't directly switch to result table frame
 // from search form frame ( because it's not includes the result table frame).
 // Most of time, we back to the top frame, then jump into other frame.
 driver.switchTo().defaultContent();

 // then switch to result table frame
 driver.switchTo().frame(<index_or_name_of_result_table_frame>);