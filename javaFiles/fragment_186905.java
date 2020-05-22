public aspect WormholeAspect {
    pointcut callerSpace(<caller context>) :
        <caller pointcut>;

    pointcut calleeSpace(<callee context>) :
        <callee pointcut>;

    pointcut wormhole(<caller context>, <callee context>) :
        cflow(callerSpace(<caller context>)) && 
        calleeSpace(<callee context>);

    // advice to wormhole
    before(<caller context>, <callee context>) :
        wormhole(<caller context>, <callee context>)
    {
            ... advice body
    }
}