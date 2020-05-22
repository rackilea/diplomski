private Deque<PencilElement> undoStack = new ArrayDeque<PencilElement>();

//whenUndo
undoStack.addFirst(myPencilElement);

//whenRedo
elements.add(undoStack.removeFirst());


//New suggestion
//whenUndo
undoStack.addFirst(elements.removeFirst());

//whenRedo
elements.add(undoStack.removeFirst());