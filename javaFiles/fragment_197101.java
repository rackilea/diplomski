const { spawn } = require('child_process');
const YOUR_COMMAND = spawn('YOUR_COMMAND', ['--arg1', 'value1', '--arg2', 'value2']);

YOUR_COMMAND.stdout.on('data', (data) => {
  console.log(`stdout: ${data}`);
});

YOUR_COMMAND.stderr.on('data', (data) => {
  console.error(`stderr: ${data}`);
});

YOUR_COMMAND.on('close', (code) => {
  console.log(`child process exited with code ${code}`);
});