d.processRaw(s, nbytes/2, false, false);
        if (nbytes > 0)
        {
    ->>>>>  d.processRaw(s, nbytes, false, false);

            Hypothesis hypothesis = d.hyp();

            if(hypothesis != null)
                System.out.println(hypothesis.getHypstr());
        }