Const White      =      1;
        Black      =     -1;

        MaxInteger =  32767;
        MinInteger = -32768;

  Function AlphaBeta (Color, Alpha, Beta, 
                             Depth, MaxDepth : Integer) : Integer; 
  var Value : Integer;

  begin
    if Depth = MaxDepth then 
       AlphaBeta := EvaluatePosition (Color)

    end else
    begin
       GenerateMoves(Color, MoveList);

       For Each Move in MoveList do
       begin
           MoveForward (Move);

               Value := AlphaBeta (-Color, Beta, Alpha,
                                           Depth +1, MaxDepth);

               if Color = White then
                  if Value > Alpha then Alpha := Value;

               if Color = Black then
                  if Value < Alpha then Alpha := Value;

           MoveBack (Move);

               if Color = White then
                  if Alpha >= Beta then Return Alpha;

               if Color = Black then
                  if Alpha <= Beta then Return Alpha;
       end;

       AlphaBeta := Alpha;
    end;
  end;