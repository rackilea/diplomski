resources.jar
`- my/path/
   |- my/directories
   `- marker.info

resources2.jar
`- my/path/
   |- my/other/directories
   `- marker.info

# search
Enumeration<URL> urls = getClass().getClassLoader().getResources("my/path/marker.info"); 

# print
print(urls);
/path/to/resources.jar!/my/path/marker.info
/path/to/resources2.jar!/my/path/marker.info