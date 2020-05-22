search(Position p) {

    if (leaf node)
        qsearch(p)

    if (need to do move reduction)
        do_move_reduction_and_cut_off(p)

    moves = generate_moves(p)

    for_each(move in moves) {            
        p.move(move)
        v = -search(p, -beta, -alpha)
        p.undo(move)

        store the score and move into a hash table

        if (v > beta)
           cutoff break;           
    }