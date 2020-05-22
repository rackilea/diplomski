grid[px][py] = <empty cell>;
switch (move) {
  case 'u': py += 1; break;
  case 'r': px += 1; break;
  ...
}
grid[px][py] = 'P';