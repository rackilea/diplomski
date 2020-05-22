grammar Shrdlu;

tokens {

    //operational tokens
    MOVE        = 'move';
    TRANSFORM   = 'transform';
    CREATE      = 'create';
    MAKE        = 'make';
    ADD         = 'add';
    REMOVE      = 'remove';
    DELETE      = 'delete';

    //shape tokens
    BOX         = 'box';
    RECTANGLE   = 'rectangel';
    CIRCLE      = 'circle';
    TRIANGLE    = 'triangle';
    SHAPE       = 'shape';
    SQUARE      = 'square';

    //color tokens
    RED         = 'red';
    BLUE        = 'blue';
    GREEN       = 'green';
    BLACK       = 'black';
    PURPLE      = 'purple';
    YELLOW      = 'yellow';
    ORANGE      = 'orange';
    PINK        = 'pink';

    //size tokens
    BIG         = 'big';
    LARGE       = 'large';
    TALL        = 'tall';
    SMALL       = 'small';
    TINY        = 'tiny';
    SHORT       = 'short';

    //relation size
    BIGGEST     = 'biggest';
    LARGEST     = 'largest';
    TALLEST     = 'tallest';
    SMALLEST    = 'smallest';   
    SHORTEST    = 'shortest';

    //argument size
    BIGGER      = 'bigger';
    SMALLER     = 'smaller';
    SHORTER     = 'shorter';
    TALLER      = 'taller';
    LARGER      = 'larger';

    //alignment tokens
    LEFT        = 'left';
    RIGHT       = 'right';
    OVER        = 'over';
    UNDER       = 'under';
    ABOVE       = 'above';
    BELOW       = 'below';
    TOP         = 'top';
    BOTTOM      = 'bottom';

    //prefix tokens
    A           = 'a';
    AN          = 'an';
    ALL         = 'all';
    ANY         = 'any';
    EACH        = 'each';
    THE         = 'the';

}

@parser::members {

  private java.awt.Graphics graphics;

  public ShrdluParser(TokenStream tokens, java.awt.Graphics g) {
    super(tokens);
    graphics = g;
  }
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

command
    :   sentence EOF
    |
    ;

sentence
    :   action object argument?
    ;

action

    :   MOVE
    |   TRANSFORM
    |   CREATE    {System.out.println("I should create a ...");}
    |   MAKE
    |   ADD
    |   REMOVE
    |   DELETE
    ;

object
    :   prefix property?  shape (relation object)?
    ;

argument
    :   color
    |   sizearg
    |   alignment
    ;

prefix
    :   A
    |   AN
    |   ALL
    |   ANY
    |   EACH
    |   THE
    ;

shape
    :   BOX       {System.out.println("box ...");}
    |   RECTANGLE
    |   CIRCLE
    |   TRIANGLE
    |   SHAPE
    |   SQUARE
    ;

property
    :   size property?
    |   color property?
    ;


size
    :   BIG
    |   LARGE
    |   TALL
    |   SMALL
    |   TINY
    |   SHORT
    ;

sizearg
    :   BIGGER
    |   LARGER
    |   SMALLER
    |   TALLER
    |   SHORTER 
    ;

relsize
    :   BIGGEST
    |   SMALLEST
    |   TALLEST
    |   LARGEST
    ;   


relation
    :   alignment
    |   relsize
    ;

color
    :   RED   {System.out.println("red ...");}
    |   BLUE
    |   GREEN
    |   BLACK
    |   PURPLE
    |   YELLOW
    |   ORANGE
    |   PINK
    ;

alignment
    :   LEFT
    |   RIGHT
    |   OVER
    |   UNDER
    |   ABOVE
    |   BELOW
    |   TOP
    |   BOTTOM
    ;

NEWLINE
    :   '\r'? '\n'
    ;

WS
    :   (' '|'\t'|'\n'|'\r')+ {skip();}
    ;