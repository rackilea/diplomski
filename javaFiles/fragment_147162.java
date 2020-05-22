javaaddpath('/home/shackle/NetBeansProjects/JavaApplication50/dist/JavaApplication50.jar')
import abc.Parser

p = Parser();
switch char(p.getFileType().toString())
    case 'BINARY'
            fprintf('type is binary')
      break;

    case 'UNHANDLED'
            fprintf('type is UNHANDLED')
      break;

    case 'XML'
            fprintf('type is XML')
      break;
end