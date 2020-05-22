create_block
 : 'block' NAME 'at' position
 ;

stack_block
 : 'stack' top=NAME 'on' bottom=NAME
 ;