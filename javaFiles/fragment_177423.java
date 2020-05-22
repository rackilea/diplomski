@Aspect
public class GetNameOverrider {

    @DeclareError("call(* a.b.C.method(..)) && !call(* a.b.C.method(int))")
    static final String errorMsg= "Signature error";
}