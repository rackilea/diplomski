/** An agglomeration of stacks: no parent */
class Agglomeration extends Element<?, Stack, Agglomeration> {…}

/** A stack of solids */
class Stack extends Element<Agglomeration, Solid, Stack> {…}

/** A solid in a stack: no children */
class Solid extends Element<Stack, ?, Solid> {…}