@Override
public boolean equals(Object o)
    {
        PacmanVeld p = (PacmanVeld)o;
        if (p.nodes.length != nodes.length) { return false; }
        for (int i = 0; i < nodes.length; i++)
        {
            if (!Arrays.deepEquals(nodes[i], p.nodes[i])) { return false; }
        }
        return true;
    }