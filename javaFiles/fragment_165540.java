BEGIN

    MAX_INPUT = 2;
    i = 0;

    WHILE i < MAX_INPUT

        TRY
            num = GET_NUM();
        CATCH
            continue;
        FINALLY
            i++

    END WHILE

END