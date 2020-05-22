import jinja2 
import codecs 
templateLoader = jinja2.FileSystemLoader( searchpath="." ) 
templateEnv    = jinja2.Environment( loader=templateLoader )
TEMPLATE_FILE  = "CodeGenerator.jinja" 
template       = templateEnv.get_template( TEMPLATE_FILE )
COLUMNS        = [tuple(line.split(':')) for line in codecs.open( "InputData.txt", "r", "utf-8" )]
COLUMNS        = map(lambda s: (s[0],(s[0].strip().title(),s[1].strip())), COLUMNS)
#title() copy of the string in which first characters of all the words are capitalized.
#strip()  copy of the string, all chars have been stripped from the beginning and the end
#lambda s --> (field1,(Field1,field1 description))
#ignore the first line 
COLUMNS.pop(0)
#add variables to work with 
templateVars = { "table" : "MyTableName",
                 "description" : "A simple code generator",
                 "columns" : COLUMNS
               }

outputText = template.render( templateVars ) 
f = open('Generated.txt', 'w') 
outputText = outputText.encode('utf-8')
f.write(outputText)
f.close() 
print outputText