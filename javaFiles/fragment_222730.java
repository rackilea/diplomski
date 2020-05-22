import {composeApi, ApiSettings} from '@burstjs/core'
import {convertNQTStringToNumber} from '@burstjs/util'

const apiSettings = new ApiSettings('http://at-testnet.burst-alliance.org:6876', 'burst');
const api = composeApi(apiSettings);

// this self-executing file makes turns this file into a starting point of your app

(async () => {
  try{
    const {balanceNQT} = await api.account.getAccountBalance('13036514135565182944')
    console.log(`Account Balance: ${convertNQTStringToNumber(balanceNQT)} BURST`)  
  }
  catch(e){ // e is of type HttpError (as part of @burstjs/http)
    console.error(`Whooops, something went wrong: ${e.message}`)      
  }
})()