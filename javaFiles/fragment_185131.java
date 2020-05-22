"""This is your target object.  
It's part of the problem domain; it rarely changes.
"""
class MyTargetObject( object ):
    def __init__( self ):
        self.someAttr= ""
        self.anotherAttr= ""
        self.this= 0
        self.that= 3.14159
    def aMethod( self ):
        """etc."""
        pass