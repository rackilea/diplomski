pragma Ada_2012;

with Interfaces.C;
with Interfaces.C.Strings;


package ada_interface is

    procedure myService (
                         inBuffer       : in     Interfaces.C.Strings.chars_ptr; -- as in
                         anInteger      : in     Interfaces.C.int;
                         outBuffer      : in     Interfaces.C.Strings.chars_ptr; -- as out buffer
                         outBufferSize  : in     Interfaces.C.int;               -- max out buffer size
                         usedBufferSize :    out Interfaces.C.int
                        );
    pragma Export (Convention    => C,
                   Entity        => myService,
                   External_Name => "Renamed_myService");
end ada_interface;