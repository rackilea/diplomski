pragma Ada_2012;


with Ada.Text_IO;

with Interfaces.C.Strings;

package body ada_interface is

    procedure myService (
                         inBuffer       : in     Interfaces.C.Strings.chars_ptr; -- as in
                         anInteger      : in     Interfaces.C.int;
                         outBuffer      : in     Interfaces.C.Strings.chars_ptr; -- as out buffer
                         outBufferSize  : in     Interfaces.C.int;               -- max out buffer size
                         usedBufferSize :    out Interfaces.C.int
                        )
    is
       -- if elaboration needs to be explicitly called
       procedure ada_elaboration;
       pragma import (C, ada_elaboration, "adalibinit"); -- "<name of lib>init". May not be needed with proper options in GPR

       Required_Length : Natural := Natural (outBufferSize);
       myString : String := "This is a sample string";
       use type Interfaces.C.size_t;
    begin

       ada_elaboration;

       --
       Ada.Text_IO.Put_Line ("======= inside myService");

       -- print the string given by char*
       Ada.Text_IO.Put_Line (Interfaces.C.Strings.Value (inBuffer));
       -- the int
       Ada.Text_IO.Put_Line (Natural'Image (Natural (anInteger)));

       -- current value of the char* to be used as OUT buffer
       Ada.Text_IO.Put_Line (Interfaces.C.Strings.Value (outBuffer));

       -- use the char* to be used as out
       Interfaces.C.Strings.Update
         (Item   => outBuffer,
          Offset => 0,
          Str    => myString & Interfaces.C.To_Ada (Interfaces.C.nul), -- "& Interfaces.C.To_Ada(Interfaces.C.nul)" is equivalent to "& Character'Val(0)"
          Check  => false);

       usedBufferSize := Interfaces.C.int (Interfaces.C.Strings.Strlen (outBuffer) - 1); -- see later java code and traces

    end myService;

end ada_interface;