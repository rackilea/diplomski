export default class Density extends Component{
...
constructor(props) {
    super(props);
    this.state = {
      mass: '',
      massUnits:[],
      volume: '',
      volumeUnits:[],
      density: 'N/A',
    };
    this.GetDerivedUnits("M",this.state.massUnits);
    this.GetDerivedUnits("L3",this.state.volumeUnits);
}

GetDerivedUnits= async (scheme,unitArray)=>{
    try{

        let asyncUnitSet = await CPPConnection.GetDerivedUnits(scheme);


        for (let i=0;i<asyncUnitSet.length;i++){
            unitArray.push(asyncUnitSet[i])
            this.setState({
                        unitArray: unitArray
                    })

        }

        console.log(asyncUnitSet);
    }catch(e){
        console.error(e);
    }
}
...
}