interface AbstractFactory {
    APIParser createAPIParser();
    APIClient createAPIClient();    
}

interface APIParser {} 
interface APIClient {}